package me.whiteship.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 컴포넌트 스캐닝을 위해 다시 애너테이션을 붙여준다.
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}