package com.paypal.bfs.test.employeeserv.api.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "first_name", "last_name", "dob", "address"})
@AllArgsConstructor
@Data
@Builder
public class EmployeeRequest {

    @JsonProperty("id")
    @JsonPropertyDescription("employee id")
    @NotNull(message="error.employee.employeeId.notNull")
    private Integer id;

    @JsonProperty("first_name")
    @JsonPropertyDescription("first name")
    @NotNull(message = "error.employee.firstName.notNull")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]*$", message="error.employee.firstName.Pattern")
    private String firstName;

    @JsonProperty("last_name")
    @JsonPropertyDescription("last name")
    @NotNull(message = "error.employee.lastName.notNull")
    @Pattern(regexp = "^[a-zA-Z]*$", message="error.employee.lastName.Pattern")
    private String lastName;

    @JsonProperty("dob")
    @JsonPropertyDescription("date of birth")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message="error.employee.dob.Pattern")
    @NotEmpty
    private String dob;

    @JsonProperty("address")
    @JsonPropertyDescription("address")
    @Valid
    private AddressRequest address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public EmployeeRequest() {
    }

    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return this.firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return this.lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("dob")
    public String getDob() {
        return this.dob;
    }

    @JsonProperty("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("address")
    public AddressRequest getAddress() {
        return this.address;
    }

    @JsonProperty("address")
    public void setAddress(AddressRequest address) {
        this.address = address;
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
        sb.append(com.paypal.bfs.test.employeeserv.api.model.Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id == null ? "<null>" : this.id);
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(this.firstName == null ? "<null>" : this.firstName);
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(this.lastName == null ? "<null>" : this.lastName);
        sb.append(',');
        sb.append("dob");
        sb.append('=');
        sb.append(this.dob == null ? "<null>" : this.dob);
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(this.address == null ? "<null>" : this.address);
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
