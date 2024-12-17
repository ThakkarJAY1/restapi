package in.dev.restapi.service;

import in.dev.restapi.DTO.ExpenseDTO;
import in.dev.restapi.entities.ExpenseEntity;
import in.dev.restapi.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ModelMapper modelMapper;
    Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);
    @Override
    public List<ExpenseDTO> getAllExpenses() {

        List<ExpenseEntity> list = expenseRepository.findAll();
        logger.info("Printing the data from repository {}",list);
        System.out.println(list);
        List<ExpenseDTO> listofExpenses = list.stream()
                .map(expenseEntity -> maptoExpenseDTO(expenseEntity))
                .collect(Collectors.toList());
        return listofExpenses;
    }

    private ExpenseDTO maptoExpenseDTO(ExpenseEntity expenseEntity){
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
