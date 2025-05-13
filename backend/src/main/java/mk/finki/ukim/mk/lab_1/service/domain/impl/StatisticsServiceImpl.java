package mk.finki.ukim.mk.lab_1.service.domain.impl;

import mk.finki.ukim.mk.lab_1.repository.UserBookRepository;
import mk.finki.ukim.mk.lab_1.service.domain.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final UserBookRepository userBookRepository;

    public StatisticsServiceImpl(UserBookRepository userBookRepository) {
        this.userBookRepository = userBookRepository;
    }

    public String getMostRentedBook() {
        List<Object[]> results = userBookRepository.findMostRentedBook();
        if (results != null && !results.isEmpty()) {
            return (String) results.get(0)[0];
        }
        return null;
    }

    public String getMostRentedAuthor() {
        List<Object[]> results = userBookRepository.findMostRentedAuthor();
        if (results != null && !results.isEmpty()) {
            return (String) results.get(0)[0];
        }
        return null;
    }

    public String getMostRentedUser() {
        List<Object[]> results = userBookRepository.findMostRentedUser();
        if (results != null && !results.isEmpty()) {
            return (String) results.get(0)[0];
        }
        return null;
    }
}
