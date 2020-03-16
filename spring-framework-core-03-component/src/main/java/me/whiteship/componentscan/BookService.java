package me.whiteship.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {
    @Autowired
    BookRepository myBookRepository;

    // 이제 Runner는 필요없다.
    @PostConstruct
    public void setup() {
        System.out.println(myBookRepository.getClass());
    }
}
