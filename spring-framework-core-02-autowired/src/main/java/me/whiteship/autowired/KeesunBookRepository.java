package me.whiteship.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class KeesunBookRepository implements BookRepository {
}
