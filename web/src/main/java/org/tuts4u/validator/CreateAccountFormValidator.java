package org.tuts4u.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.tuts4u.form.CreateAccountForm;

@SuppressWarnings("rawtypes")
public class CreateAccountFormValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return CreateAccountForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		CreateAccountForm form = (CreateAccountForm)target;
		
	}

}
