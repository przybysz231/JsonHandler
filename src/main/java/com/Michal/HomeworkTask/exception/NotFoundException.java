package com.Michal.HomeworkTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No results found")
public class NotFoundException extends RuntimeException{
}
