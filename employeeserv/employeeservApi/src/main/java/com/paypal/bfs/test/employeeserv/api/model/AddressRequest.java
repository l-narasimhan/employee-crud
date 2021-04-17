package com.paypal.bfs.test.employeeserv.api.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"address_line1", "address_line2", "city", "state", "country", "zip"})
@AllArgsConstructor
@Data
@Builder
public class AddressRequest {
    @JsonProperty("address_line1")
    @JsonPropertyDescription("address line 1")
    @NotNull(message = "error.address.addline1.notNull")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message="error.address.addline1.Pattern")
    private String addressLine1;

    @JsonProperty("address_line2")
    @JsonPropertyDescription("address line 2")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message="error.address.addline2.Pattern")
    private String addressLine2;

    @JsonProperty("city")
    @JsonPropertyDescription("name of city")
    @NotNull(message = "error.address.city.notNull")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message="error.address.city.Pattern")
    private String city;

    @JsonProperty("state")
    @JsonPropertyDescription("name of state")
    @NotNull(message = "error.address.state.notNull")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message="error.address.state.Pattern")
    private String state;

    @JsonProperty("country")
    @JsonPropertyDescription("name of country")
    @NotNull(message = "error.address.country.notNull")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message="error.address.country.Pattern")
    private String country;

    @JsonProperty("zip")
    @JsonPropertyDescription("pin code")
    @NotNull(message = "error.address.zip.notNull")
    @NotEmpty
    @Pattern(regexp = "^[0-9]*$", message="error.address.zip.Pattern")
    private String zip;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public AddressRequest() {
    }

    @JsonProperty("address_line1")
    public String getAddressLine1() {
        return this.addressLine1;
    }

    @JsonProperty("address_line1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @JsonProperty("address_line2")
    public String getAddressLine2() {
        return this.addressLine2;
    }

    @JsonProperty("address_line2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @JsonProperty("city")
    public String getCity() {
        return this.city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {
        return this.state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("country")
    public String getCountry() {
        return this.country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("zip")
    public String getZip() {
        return this.zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(com.paypal.bfs.test.employeeserv.api.model.AddressRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addressLine1");
        sb.append('=');
        sb.append(this.addressLine1 == null ? "<null>" : this.addressLine1);
        sb.append(',');
        sb.append("addressLine2");
        sb.append('=');
        sb.append(this.addressLine2 == null ? "<null>" : this.addressLine2);
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(this.city == null ? "<null>" : this.city);
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(this.state == null ? "<null>" : this.state);
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(this.country == null ? "<null>" : this.country);
        sb.append(',');
        sb.append("zip");
        sb.append('=');
        sb.append(this.zip == null ? "<null>" : this.zip);
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(this.additionalProperties == null ? "<null>" : this.additionalProperties);
        sb.append(',');
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append(']');
        }

        return sb.toString();
    }
}
