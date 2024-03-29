package mx.edu.utez.ExamenU2.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomResponse <T>{
    T data;
    Boolean error;
    int StatusCode;
    String message;
}

