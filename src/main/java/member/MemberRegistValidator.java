package member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberRegistValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberRegistRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberRegistRequest regReq = (MemberRegistRequest) target;
		
		if(regReq.getEmail()== null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		
		if(regReq.hasPassword()) {
			if(regReq.getPassword().length() < 5) {
				errors.rejectValue("password", "shortPassword");
			} else if(!regReq.isSamePasswordConfirmPassword()) {
				errors.rejectValue("confirmPassword", "notSame");
			}
		} // end of if(regReq.hasPassword())
		
		Address address = regReq.getAddress();
		if(address == null) {
			errors.rejectValue("address", "required");
		} else {
			errors.pushNestedPath("address");
			try {
				ValidationUtils.rejectIfEmpty(errors, "address1", "required");
				ValidationUtils.rejectIfEmpty(errors, "address2", "required");
			} finally {
				errors.popNestedPath();
			}
		} // end of if(address == null)
		
		ValidationUtils.rejectIfEmpty(errors, "birthday", "required");
	} // end of validate()

} // end of class MemberRegistValidator
