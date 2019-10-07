package com.projects.stockviewer.dbservice.controller;

import com.projects.stockviewer.dbservice.model.Quote;
import com.projects.stockviewer.dbservice.model.QuoteModel;
import com.projects.stockviewer.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/db/")
public class dbserviceController {

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping(value = "{userName}")
    public List<String> getQuotes(@PathVariable(value = "userName") final String userName) {

        return getQuotesByUserName(userName);
    }

    @PostMapping(value = "add")
    public List<String> addQuote(@RequestBody QuoteModel quoteModel) {

        quoteModel.getQuotes()
                .stream()
                .map(quote -> new Quote(quoteModel.getUserName(),quote))
                .forEach(quote -> quotesRepository.save(quote));
        return getQuotesByUserName(quoteModel.getUserName());
    }

    @PostMapping(value = "delete/{userName}")
    public List<String> deleteQuotes(@PathVariable(value = "userName") String userName) {
        List<Quote> quotes = quotesRepository.findByUserName(userName);
        for (Quote q: quotes) {
            quotesRepository.delete(q);
        }
         return getQuotesByUserName(userName);
    }
    private List<String> getQuotesByUserName(@PathVariable("userName") String userName) {
        return quotesRepository.findByUserName(userName)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }
}
