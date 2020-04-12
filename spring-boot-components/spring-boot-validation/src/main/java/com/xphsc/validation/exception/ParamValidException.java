package com.xphsc.validation.exception;

import com.github.xtool.collect.Lists;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
public class ParamValidException extends Exception {
    Logger log = LoggerFactory.getLogger(getClass());

    private List<FieldError> fieldErrors = new ArrayList<FieldError>();

    /**
     *
     */
    private static final long serialVersionUID = -716441870779206738L;

    @Override
    public String getMessage() {
        return fieldErrors.toString();
    }

    public ParamValidException(ConstraintViolationException violationException, MethodParameter[] methodParameters) {
        List<FieldError> errors =null;
        for(ConstraintViolation<?> constraintViolation:violationException.getConstraintViolations()){
            PathImpl pathImpl = (PathImpl)constraintViolation.getPropertyPath();
            int paramIndex = pathImpl.getLeafNode().getParameterIndex();
            String paramName = methodParameters[paramIndex].getParameterName();
            FieldError error = new FieldError();
            error.setName(paramName);
            error.setMessage(constraintViolation.getMessage());
            errors.add(error);
       }
       this.fieldErrors = errors;

    }
    public ParamValidException(MethodArgumentNotValidException m, MethodParameter[] methodParameters) {
        List<FieldError> errors = Lists.newLinkedList();
        for(org.springframework.validation.FieldError fieldError:m.getBindingResult().getFieldErrors()){
            FieldError error = new FieldError();
            error.setName(fieldError.getField());
            error.setMessage(fieldError.getDefaultMessage());
            errors.add(error);
        }
        this.fieldErrors = errors;

    }


    public ParamValidException(List<FieldError> errors) {
        this.fieldErrors = errors;
    }

    public ParamValidException(BindException ex) {
        this.fieldErrors = bindExceptionToFieldError(ex);
    }

    private List<FieldError> bindExceptionToFieldError(BindException ex) {
        List<FieldError> FieldErrorlist= Lists.newArrayList();
        List<org.springframework.validation.FieldError> flist=ex.getFieldErrors();
        for(org.springframework.validation.FieldError f:flist){
            FieldError error = new FieldError();
            error.setName(f.getObjectName() + "." + f.getField());
            error.setMessage(f.getDefaultMessage());
            FieldErrorlist.add(error);
        }
     return FieldErrorlist;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
