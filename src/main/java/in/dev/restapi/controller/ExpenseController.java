package in.dev.restapi.controller;

import in.dev.restapi.DTO.ExpenseDTO;
import in.dev.restapi.io.ExpenseResponse;
import in.dev.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {
    private ExpenseService expenseService;
    private ModelMapper modelMapper;

    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){

        List<ExpenseDTO> list = expenseService.getAllExpenses();

        List<ExpenseResponse> response = list.stream()
                .map(expenseDTO -> mapToExpenseResponse(expenseDTO))
                .collect(Collectors.toList());

        return response;
    }

    @GetMapping("/expense")
    public String getExpenses1(){
        return "Reading the expenses from database";
    }

    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
