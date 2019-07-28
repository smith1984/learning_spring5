package ru.smith.ch04.xml.propertyeditor;

import lombok.*;

@ToString
@AllArgsConstructor
public class FullName {

    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;
}
