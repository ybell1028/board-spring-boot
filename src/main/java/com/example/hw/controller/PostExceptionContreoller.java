package com.example.hw.controller;
import com.example.hw.errhandler.NoItemError;
import com.example.hw.errhandler.PathFormatError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.NoSuchElementException;

// 스프링 프레임워크 에서는 @ControllerAdvice라는 어노테이션을 통해 특정 클래스에 예외를 모아둘수 있게 해두었다.
@ControllerAdvice
public class PostExceptionContreoller {
    /* 스프링 프레임워크에 있는 @ExceptionHandler 어노테이션을 통해서
     * 잫못된 id값이나 데이터베이스에 없는 값들을 조회/삭제/수정했을때에 대한
     * 예외처리 핸들러들을 지정해주었다. 이제 예외가 발생할 상황이 되면
     * throw를 통해서 ExceptionHandler로 예외를 넘겨주면 된다.
     * 이 때, 포스트 id 값이 틀린경우에는 NumberFormatException 예외가 발생하고,
     *  아이템이 존재하지 않는 경우에는 NoSuchElementException 예외가 발생하게 된다.*/

    @ExceptionHandler(NoSuchElementException.class)
    public @ResponseBody
    NoItemError noItemErrorHandler(NoSuchElementException e){
        NoItemError noItem = new NoItemError();
        noItem.setMessage("Item Not Exists!");
        return noItem;
    }

    @ExceptionHandler(NumberFormatException.class)
    public @ResponseBody
    PathFormatError noItemErrorHandler(NumberFormatException e){
        PathFormatError formatError = new PathFormatError();
        formatError.setMessage("Invalid Path Variable!");
        return formatError;
    }

    /* 이제 맨 위에서 언급한 try-catch의 지옥을 겪지 않아도 적절하게 예외가 처리된다.
     모든 예외 처리 로직이 @ExceptionHandler 어노테이션을 붙인 함수로 집중되었다. */
}
