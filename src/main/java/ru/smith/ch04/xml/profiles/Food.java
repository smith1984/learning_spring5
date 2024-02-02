package ru.smith.ch04.xml.profiles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Getter @Setter
    private String name;
}