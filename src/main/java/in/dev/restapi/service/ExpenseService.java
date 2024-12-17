package in.dev.restapi.service;

import in.dev.restapi.DTO.ExpenseDTO;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * service interface for Expense module*/
@Service
public interface ExpenseService {

    /**
     * It will fetch the expenses from database
     * @return list
     * */

    List<ExpenseDTO> getAllExpenses();
}
