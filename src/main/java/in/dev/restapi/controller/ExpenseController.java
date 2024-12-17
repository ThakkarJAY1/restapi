package in.dev.restapi.controller;

import in.dev.restapi.DTO.ExpenseDTO;
import in.dev.restapi.io.ExpenseResponse;
import in.dev.restapi.service.ExpenseService;
import in.dev.restapi.service.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is controller class for Expense Module
 * */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {


    Logger logger = LoggerFactory.getLogger(ExpenseController.class);
    @Autowired
    private ExpenseServiceImpl expenseService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     * */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
        logger.info("API GET /expenses called");
        List<ExpenseDTO> list = expenseService.getAllExpenses();

        logger.info("Printing the data from service {}",list);
        return list.stream()
                .map(expenseDTO -> mapToExpenseResponse(expenseDTO))
                .collect(Collectors.toList());
    }

    @GetMapping("/expense")
    public String getExpenses1(){
        return "Reading the expenses from database";
    }

    /**
     * Mapper method for converting expense DTO object to expense response
     * @param expenseDTO
     * @return ExpenseResponse
     * */
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
