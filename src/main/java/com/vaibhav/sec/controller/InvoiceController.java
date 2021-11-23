package com.vaibhav.sec.controller;
import com.vaibhav.sec.model.*;
import com.vaibhav.sec.repo.*;
import com.vaibhav.sec.responce.InvoiceRequest;
import com.vaibhav.sec.responce.InvoiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    DebtsRepository debtsRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PaymentMethodeRepo paymentMethodeRepo;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ClientInvoiceRepo clientInvoiceRepo;
    @PostMapping(value = "/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Invoice invoice,@PathVariable Long organizationId){
        return ResponseEntity.ok(invoiceRepository.save(invoice));
    }
    @GetMapping(value = "/byUser/{id}/{organizationId}")
    public ResponseEntity<?> getByUserId(@PathVariable Long id,@PathVariable Long organizationId){
        return ResponseEntity.ok(invoiceRepository.getByUserId(id));
    }
    @GetMapping(value = "/getByUserId/{id}/{organizationId}")
    public ResponseEntity<?>getByUser(@PathVariable Long id,@PathVariable Long organizationId){
        return ResponseEntity.ok(debtsRepository.getByUserId(id));
    }
    @PostMapping(value = "/addDebts/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody Debts debts,@PathVariable Long organizationId){
        return ResponseEntity.ok(debtsRepository.save(debts));
    }
    @GetMapping(value = "/getAllInvoice/{organizationId}")
    public ResponseEntity<?> getAllInvoice(@PathVariable Long organizationId){
        return ResponseEntity.ok(addInvoice(invoiceRepository.getByStatus("Finish")));
    }
    List<InvoiceResponse> addInvoice(List<Invoice> invoices){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        List<InvoiceResponse> invoiceResponseList= new ArrayList<>();
        invoices.forEach(invoice -> {
            InvoiceResponse invoiceResponse=new InvoiceResponse();
            invoiceResponse.setId(invoice.getId());
            invoiceResponse.setClient(clientRepository.getById(invoice.getUserId()));
            invoiceResponse.setDate(formatter.format(calendar.getTime()));
            invoiceResponse.setImage(invoice.getImage());
            invoiceResponse.setWalletId(invoice.getWalletId());
            invoiceResponse.setTime(invoice.getTime());
            invoiceResponse.setEmployId(invoice.getEmployId());
            invoiceResponse.setPaymentMethode(paymentMethodeRepo.getById(invoice.getPaymentMethodeId()));
            invoiceResponse.setTitle(invoice.getTitle());
            invoiceResponse.setTotal(invoice.getTotal());
            invoiceResponse.setOrganizationId(invoice.getOrganizationId());
            invoiceResponse.setOrders(orderRepository.getByInvoiceId(invoice.getId()));
            invoiceResponseList.add(invoiceResponse);
        });
        return invoiceResponseList;
    }
    @PostMapping(value = "/addOnCourInvoice/{organizationId}")
    public ResponseEntity<?> addInvoice(@RequestBody InvoiceRequest invoiceResponse,@PathVariable Long organizationId){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Invoice invoice = new Invoice();
        invoice.setTime(dateFormat.format(date));
        invoice.setDate(formatter.format(calendar.getTime()));
        invoice.setImage(invoiceResponse.getImage());
        invoice.setTitle(invoiceResponse.getTitle());
        invoice.setTotal(invoiceResponse.getTotal());
        invoice.setUserId(invoiceResponse.getClient());
        invoice.setWalletId(invoiceResponse.getPaymentId());
        invoice.setOrganizationId(organizationId);
        invoice.setStatus("enCour");
        Invoice invoice1 = invoiceRepository.save(invoice);


        for (int i=0;i<invoiceResponse.getOrders().size();i++){
            Order order= new Order();
            order.setDate(formatter.format(calendar.getTime()));
            order.setInvoiceId(invoice1.getId());
            order.setEmployId(invoiceResponse.getOrders().get(i).getEmployId());
            order.setPrice(invoiceResponse.getOrders().get(i).getPrice());
            order.setProductId(invoiceResponse.getOrders().get(i).getProductId());
            order.setProductName(invoiceResponse.getOrders().get(i).getProductName());
            order.setQ(invoiceResponse.getOrders().get(i).getQuentite());
            order.setReference(invoiceResponse.getOrders().get(i).getReference());
            order.setStatus("enCour");
            orderRepository.save(order);
        }
        return ResponseEntity.ok(invoiceResponse);
    }
    @GetMapping(value = "/getOnCourInvoice/{organizationId}")
    public ResponseEntity<?> getOnCourInvoice(){
        return ResponseEntity.ok(addInvoice(invoiceRepository.getByStatus("enCour")));
    }
    @PostMapping(value = "/addInvoice/{organizationId}")
    public ResponseEntity<?> addInvoiceV(@RequestBody InvoiceRequest invoiceResponse,@PathVariable Long organizationId){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Invoice invoice = new Invoice();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        invoice.setTime(dateFormat.format(date));
        invoice.setId(invoiceResponse.getId());
        invoice.setDate(formatter.format(calendar.getTime()));
        invoice.setImage(invoiceResponse.getImage());
        invoice.setTitle(invoiceResponse.getTitle());
        invoice.setTotal(invoiceResponse.getTotal());
        invoice.setUserId(invoiceResponse.getClient());
        invoice.setWalletId(invoiceResponse.getPaymentId());
        invoice.setPaymentMethodeId(invoiceResponse.getPaymentMethodeId());
        invoice.setStatus("Finish");
        Invoice invoice1 = invoiceRepository.save(invoice);
        ClientInvoice clientInvoice = clientInvoiceRepo.getByClientIdAndOrganizationId(invoiceResponse.getClient(),organizationId);
        clientInvoice.setTotalAppointment(clientInvoice.getTotalAppointment()+1);
        Double total1=Double.valueOf(clientInvoice.getTotal())+Double.valueOf(invoiceResponse.getTotal());
        clientInvoice.setPoints(clientInvoice.getPoints()+invoiceResponse.getOrders().size());
        clientInvoice.setTotal(total1.toString());
        clientInvoiceRepo.save(clientInvoice);
        for (int i=0;i<invoiceResponse.getOrders().size();i++){
            Order order= new Order();
            order.setDate(invoiceResponse.getDate());
            order.setInvoiceId(invoice1.getId());
            order.setEmployId(invoiceResponse.getOrders().get(i).getEmployId());
            order.setPrice(invoiceResponse.getOrders().get(i).getPrice());
            order.setProductId(invoiceResponse.getOrders().get(i).getProductId());
            order.setProductName(invoiceResponse.getOrders().get(i).getProductName());
            order.setQ(invoiceResponse.getOrders().get(i).getQuentite());
            order.setReference(invoiceResponse.getOrders().get(i).getReference());
            order.setStatus("Finish");
            orderRepository.save(order);
        }
        PaymentModel paymentModel= paymentRepository.getById(invoiceResponse.getPaymentId());
        Double total = Double.valueOf(paymentModel.getTotal()) + Double.valueOf(invoice.getTotal());
        paymentModel.setTotal(total.toString());
        paymentModel.setPassages(paymentModel.getPassages()+1);
        paymentModel.setPoints(paymentModel.getPoints()+1);
        paymentModel.setDate(formatter.format(calendar.getTime()));
        paymentRepository.save(paymentModel);
        return ResponseEntity.ok(invoiceResponse);
    }
    @PostMapping(value = "/addPresent/{organizationId}")
    public ResponseEntity<?> addPresent(@RequestBody InvoiceRequest invoiceResponse,@PathVariable Long organizationId){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Invoice invoice = new Invoice();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        invoice.setTime(dateFormat.format(date));
        invoice.setId(invoiceResponse.getId());
        invoice.setDate(formatter.format(calendar.getTime()));
        invoice.setImage(invoiceResponse.getImage());
        invoice.setTitle(invoiceResponse.getTitle());
        invoice.setTotal(invoiceResponse.getTotal());
        invoice.setUserId(invoiceResponse.getClient());
        invoice.setWalletId(invoiceResponse.getPaymentId());
        invoice.setPaymentMethodeId(invoiceResponse.getPaymentMethodeId());
        invoice.setStatus("Present");
        Invoice invoice1 = invoiceRepository.save(invoice);

        ClientInvoice clientInvoice = clientInvoiceRepo.getByClientIdAndOrganizationId(invoiceResponse.getClient(),organizationId);
        clientInvoice.setTotalAppointment(clientInvoice.getTotalAppointment()+1);
        Double total1=Double.valueOf(clientInvoice.getTotal())+Double.valueOf(invoiceResponse.getTotal());
        clientInvoice.setPoints(clientInvoice.getPoints()+invoiceResponse.getOrders().size());
        clientInvoice.setTotal(total1.toString());
        clientInvoiceRepo.save(clientInvoice);

        for (int i=0;i<invoiceResponse.getOrders().size();i++){
            Order order= new Order();
            order.setDate(invoiceResponse.getDate());
            order.setInvoiceId(invoice1.getId());
            order.setEmployId(invoiceResponse.getOrders().get(i).getEmployId());
            order.setPrice(invoiceResponse.getOrders().get(i).getPrice());
            order.setProductId(invoiceResponse.getOrders().get(i).getProductId());
            order.setProductName(invoiceResponse.getOrders().get(i).getProductName());
            order.setQ(invoiceResponse.getOrders().get(i).getQuentite());
            order.setReference(invoiceResponse.getOrders().get(i).getReference());
            order.setStatus("Finish");
            orderRepository.save(order);
        }
        PaymentModel paymentModel= paymentRepository.getById(invoiceResponse.getPaymentId());
        Double total = Double.valueOf(paymentModel.getTotal()) + Double.valueOf(invoice.getTotal());
        paymentModel.setTotal(total.toString());
        paymentModel.setPassages(paymentModel.getPassages()+1);
        paymentModel.setPoints(paymentModel.getPoints()+1);
        paymentModel.setDate(formatter.format(calendar.getTime()));
        paymentRepository.save(paymentModel);
        return ResponseEntity.ok(invoiceResponse);
    }

    @GetMapping(value = "/clientInvoice/{id}/{organizationId}")
    public ResponseEntity<?> getClientInvoice(@PathVariable Long id,@PathVariable Long organizationId){
        ClientInvoice clientInvoice = clientInvoiceRepo.getByClientIdAndOrganizationId(id,organizationId);
        if (clientInvoice==null||clientInvoice.getId()==null) {
            ClientInvoice clientInvoice1= new ClientInvoice();
            Client client = clientRepository.getById(id);
            clientInvoice1.setClientId(id);
            clientInvoice1.setDettes("0");
            clientInvoice1.setFirstname(client.getFirstname());
            clientInvoice1.setLastname(client.getLastname());
            clientInvoice1.setFuture("0");
            clientInvoice1.setOrganizationId(organizationId);
            clientInvoice1.setTotalAppointment(0);
            clientInvoice1.setPoints(0);
            clientInvoice1.setPresent("0");
            return ResponseEntity.ok(clientInvoiceRepo.save(clientInvoice1));
        }else {
            return ResponseEntity.ok(clientInvoiceRepo.getByClientIdAndOrganizationId(id,organizationId));
        }

    }
}