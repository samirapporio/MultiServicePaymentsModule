package com.apporioinfolabs.paymentmodule.models;

import java.util.List;

public class ModelSecret {

    /**
     * id : pi_1Fwja6ID0Un0nndSNWbbQEbp
     * object : payment_intent
     * amount : 566874
     * amount_capturable : 0
     * amount_received : 0
     * application : null
     * application_fee_amount : null
     * canceled_at : null
     * cancellation_reason : null
     * capture_method : automatic
     * charges : {"object":"list","data":[],"has_more":false,"total_count":0,"url":"/v1/charges?payment_intent=pi_1Fwja6ID0Un0nndSNWbbQEbp"}
     * client_secret : pi_1Fwja6ID0Un0nndSNWbbQEbp_secret_9Roufxvlk5hNrpu6op0BZb3xC
     * confirmation_method : automatic
     * created : 1578032662
     * currency : inr
     * customer : null
     * description : null
     * invoice : null
     * last_payment_error : null
     * livemode : false
     * metadata : {}
     * next_action : null
     * on_behalf_of : null
     * payment_method : null
     * payment_method_options : {"card":{"installments":null,"request_three_d_secure":"automatic"}}
     * payment_method_types : ["card"]
     * receipt_email : null
     * review : null
     * setup_future_usage : null
     * shipping : null
     * source : null
     * statement_descriptor : null
     * statement_descriptor_suffix : null
     * status : requires_payment_method
     * transfer_data : null
     * transfer_group : null
     */

    private String id;
    private String object;
    private int amount;
    private int amount_capturable;
    private int amount_received;
    private Object application;
    private Object application_fee_amount;
    private Object canceled_at;
    private Object cancellation_reason;
    private String capture_method;
    private ChargesBean charges;
    private String client_secret;
    private String confirmation_method;
    private int created;
    private String currency;
    private Object customer;
    private Object description;
    private Object invoice;
    private Object last_payment_error;
    private boolean livemode;
    private MetadataBean metadata;
    private Object next_action;
    private Object on_behalf_of;
    private Object payment_method;
    private PaymentMethodOptionsBean payment_method_options;
    private Object receipt_email;
    private Object review;
    private Object setup_future_usage;
    private Object shipping;
    private Object source;
    private Object statement_descriptor;
    private Object statement_descriptor_suffix;
    private String status;
    private Object transfer_data;
    private Object transfer_group;
    private List<String> payment_method_types;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount_capturable() {
        return amount_capturable;
    }

    public void setAmount_capturable(int amount_capturable) {
        this.amount_capturable = amount_capturable;
    }

    public int getAmount_received() {
        return amount_received;
    }

    public void setAmount_received(int amount_received) {
        this.amount_received = amount_received;
    }

    public Object getApplication() {
        return application;
    }

    public void setApplication(Object application) {
        this.application = application;
    }

    public Object getApplication_fee_amount() {
        return application_fee_amount;
    }

    public void setApplication_fee_amount(Object application_fee_amount) {
        this.application_fee_amount = application_fee_amount;
    }

    public Object getCanceled_at() {
        return canceled_at;
    }

    public void setCanceled_at(Object canceled_at) {
        this.canceled_at = canceled_at;
    }

    public Object getCancellation_reason() {
        return cancellation_reason;
    }

    public void setCancellation_reason(Object cancellation_reason) {
        this.cancellation_reason = cancellation_reason;
    }

    public String getCapture_method() {
        return capture_method;
    }

    public void setCapture_method(String capture_method) {
        this.capture_method = capture_method;
    }

    public ChargesBean getCharges() {
        return charges;
    }

    public void setCharges(ChargesBean charges) {
        this.charges = charges;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getConfirmation_method() {
        return confirmation_method;
    }

    public void setConfirmation_method(String confirmation_method) {
        this.confirmation_method = confirmation_method;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getInvoice() {
        return invoice;
    }

    public void setInvoice(Object invoice) {
        this.invoice = invoice;
    }

    public Object getLast_payment_error() {
        return last_payment_error;
    }

    public void setLast_payment_error(Object last_payment_error) {
        this.last_payment_error = last_payment_error;
    }

    public boolean isLivemode() {
        return livemode;
    }

    public void setLivemode(boolean livemode) {
        this.livemode = livemode;
    }

    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
    }

    public Object getNext_action() {
        return next_action;
    }

    public void setNext_action(Object next_action) {
        this.next_action = next_action;
    }

    public Object getOn_behalf_of() {
        return on_behalf_of;
    }

    public void setOn_behalf_of(Object on_behalf_of) {
        this.on_behalf_of = on_behalf_of;
    }

    public Object getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Object payment_method) {
        this.payment_method = payment_method;
    }

    public PaymentMethodOptionsBean getPayment_method_options() {
        return payment_method_options;
    }

    public void setPayment_method_options(PaymentMethodOptionsBean payment_method_options) {
        this.payment_method_options = payment_method_options;
    }

    public Object getReceipt_email() {
        return receipt_email;
    }

    public void setReceipt_email(Object receipt_email) {
        this.receipt_email = receipt_email;
    }

    public Object getReview() {
        return review;
    }

    public void setReview(Object review) {
        this.review = review;
    }

    public Object getSetup_future_usage() {
        return setup_future_usage;
    }

    public void setSetup_future_usage(Object setup_future_usage) {
        this.setup_future_usage = setup_future_usage;
    }

    public Object getShipping() {
        return shipping;
    }

    public void setShipping(Object shipping) {
        this.shipping = shipping;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getStatement_descriptor() {
        return statement_descriptor;
    }

    public void setStatement_descriptor(Object statement_descriptor) {
        this.statement_descriptor = statement_descriptor;
    }

    public Object getStatement_descriptor_suffix() {
        return statement_descriptor_suffix;
    }

    public void setStatement_descriptor_suffix(Object statement_descriptor_suffix) {
        this.statement_descriptor_suffix = statement_descriptor_suffix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getTransfer_data() {
        return transfer_data;
    }

    public void setTransfer_data(Object transfer_data) {
        this.transfer_data = transfer_data;
    }

    public Object getTransfer_group() {
        return transfer_group;
    }

    public void setTransfer_group(Object transfer_group) {
        this.transfer_group = transfer_group;
    }

    public List<String> getPayment_method_types() {
        return payment_method_types;
    }

    public void setPayment_method_types(List<String> payment_method_types) {
        this.payment_method_types = payment_method_types;
    }

    public static class ChargesBean {
    }

    public static class MetadataBean {
    }

    public static class PaymentMethodOptionsBean {
        /**
         * card : {"installments":null,"request_three_d_secure":"automatic"}
         */

        private CardBean card;

        public CardBean getCard() {
            return card;
        }

        public void setCard(CardBean card) {
            this.card = card;
        }

        public static class CardBean {
            /**
             * installments : null
             * request_three_d_secure : automatic
             */

            private Object installments;
            private String request_three_d_secure;

            public Object getInstallments() {
                return installments;
            }

            public void setInstallments(Object installments) {
                this.installments = installments;
            }

            public String getRequest_three_d_secure() {
                return request_three_d_secure;
            }

            public void setRequest_three_d_secure(String request_three_d_secure) {
                this.request_three_d_secure = request_three_d_secure;
            }
        }
    }
}
