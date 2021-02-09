package expert.springframework.classicbooks.formatters;

import expert.springframework.classicbooks.model.BookType;
import expert.springframework.classicbooks.services.BookTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class BookTypeFormatter implements Formatter<BookType> {

    private final BookTypeService bookTypeService;

    public BookTypeFormatter(BookTypeService bookTypeService) {
        this.bookTypeService = bookTypeService;
    }

    @Override
    public BookType parse(String text, Locale locale) throws ParseException {

        Collection<BookType> findBookTypes = bookTypeService.findAll();
        for (BookType type : findBookTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);

    }

    @Override
    public String print(BookType bookType, Locale locale) {
        return bookType.getName();
    }

}
