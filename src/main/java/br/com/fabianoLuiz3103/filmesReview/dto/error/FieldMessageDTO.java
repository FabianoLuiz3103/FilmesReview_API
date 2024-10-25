package br.com.fabianoLuiz3103.filmesReview.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FieldMessageDTO {

    private String fieldName;
    private String message;
}

