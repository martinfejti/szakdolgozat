package hu.szakdolgozat.tm.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.entity.CaseEntity;
import hu.szakdolgozat.tm.entity.ComponentEntity;
import hu.szakdolgozat.tm.entity.ProjectEntity;
import hu.szakdolgozat.tm.entity.StepEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.repository.ComponentRepository;
import hu.szakdolgozat.tm.repository.ProjectRepository;
import hu.szakdolgozat.tm.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private ComponentRepository componentRepository;
    
    public ExcelServiceImpl() {
    }
    
    private static final String CASE_ID = "Case ID";
    private static final String CASE_NAME = "Case Name";
    private static final String CASE_DESCRIPTION = "Case Description";
    private static final String STEP_NUMBER = "Step No.";
    private static final String STEP_DESCRIPTION = "Step Description";
    private static final String STEP_EXPECTED_RESULT = "Step Expected Result";
    private static final String STEP_COMMENT = "Step Comment";
    
    @Override
    public void exportProjectIntoExcel(Long id) throws ServiceException {
        try {
            ProjectEntity projectEntity = this.projectRepository.getProjectById(id);
            
            XSSFWorkbook workbook = new XSSFWorkbook();
            
            XSSFSheet projectSheet = workbook.createSheet("Project details");
            
            Row nameRow = projectSheet.createRow(0);
            Cell nameLabelCell = nameRow.createCell(0);
            nameLabelCell.setCellValue("Project name:");
            
            Cell nameCell = nameRow.createCell(1);
            nameCell.setCellValue(projectEntity.getName());
            
            Row shortDescriptionRow = projectSheet.createRow(1);
            Cell shortDescriptionLabelCell = shortDescriptionRow.createCell(0);
            shortDescriptionLabelCell.setCellValue("Project short description:");
            
            Cell shortDescriptionCell = shortDescriptionRow.createCell(1);
            shortDescriptionCell.setCellValue(projectEntity.getShortDescription());
            
            Row longDescriptionRow = projectSheet.createRow(2);
            Cell longDescriptionLabelCell = longDescriptionRow.createCell(0);
            longDescriptionLabelCell.setCellValue("Project long description:");
            
            Cell longDescriptionCell = longDescriptionRow.createCell(1);
            longDescriptionCell.setCellValue(projectEntity.getLongDescription());
            
            projectSheet.setColumnWidth(0, 10000);
            projectSheet.setColumnWidth(1, 10000);
            
            if (projectEntity.getComponentEntities() != null && !projectEntity.getComponentEntities().isEmpty()) {
                for (int i = 0; i < projectEntity.getComponentEntities().size(); i++) {
                    ComponentEntity componentEntity = projectEntity.getComponentEntities().get(i);
                    XSSFSheet sheet = workbook.createSheet(componentEntity.getName());
                    
                    int rowCounter = 0;
                    
                    // Create header row
                    Row mainRow = sheet.createRow(0);
                    rowCounter++;
                    
                    CellStyle style = workbook.createCellStyle();
                    style.setBorderBottom(BorderStyle.THICK);
                    style.setBorderLeft(BorderStyle.THICK);
                    style.setBorderRight(BorderStyle.THICK);
                    style.setBorderTop(BorderStyle.THICK);

                    Cell cell0 = mainRow.createCell(0);
                    cell0.setCellValue(CASE_ID);
                    cell0.setCellStyle(style);
                    
                    Cell cell1 = mainRow.createCell(1);
                    cell1.setCellValue(CASE_NAME);
                    cell1.setCellStyle(style);
                    
                    Cell cell2 = mainRow.createCell(2);
                    cell2.setCellValue(CASE_DESCRIPTION);
                    cell2.setCellStyle(style);
                    
                    Cell cell3 = mainRow.createCell(3);
                    cell3.setCellValue(STEP_NUMBER);
                    cell3.setCellStyle(style);
                    
                    Cell cell4 = mainRow.createCell(4);
                    cell4.setCellValue(STEP_DESCRIPTION);
                    cell4.setCellStyle(style);
                    
                    Cell cell5 = mainRow.createCell(5);
                    cell5.setCellValue(STEP_EXPECTED_RESULT);
                    cell5.setCellStyle(style);

                    Cell cell6 = mainRow.createCell(6);
                    cell6.setCellValue(STEP_COMMENT);
                    cell6.setCellStyle(style);
                    
                    CellStyle borderStyle = workbook.createCellStyle();
                    borderStyle.setBorderTop(BorderStyle.DOUBLE);
                    
                    sheet.setColumnWidth(0, 2000);
                    sheet.setColumnWidth(1, 8000);
                    sheet.setColumnWidth(2, 10000);
                    sheet.setColumnWidth(3, 2000);
                    sheet.setColumnWidth(4, 10000);
                    sheet.setColumnWidth(5, 10000);
                    sheet.setColumnWidth(6, 6000);
                    
                    // create other rows
                    for (int j = 0; j < componentEntity.getCaseEntities().size(); j++) {
                        CaseEntity caseEntity = componentEntity.getCaseEntities().get(j);
                        
                        Row row = sheet.createRow(j + rowCounter);
                        
                        Cell caseIdCell = row.createCell(0);
                        caseIdCell.setCellValue(caseEntity.getId());
                        
                        Cell caseNameCell = row.createCell(1);
                        caseNameCell.setCellValue(caseEntity.getName());
                        
                        Cell caseDescriptionCell = row.createCell(2);
                        caseDescriptionCell.setCellValue(caseEntity.getDescription());
                        
                        // create steps
                        for (int k = 0; k < caseEntity.getSteps().size(); k++) {
                            StepEntity stepEntity = caseEntity.getSteps().get(k);
                            
                            if (k == 0) {
                                Cell stepNumberCell = row.createCell(3);
                                stepNumberCell.setCellValue(stepEntity.getOrderNumber());
                                stepNumberCell.setCellStyle(borderStyle);
                                
                                Cell stepDescriptionCell = row.createCell(4);
                                stepDescriptionCell.setCellValue(stepEntity.getDescription());
                                stepDescriptionCell.setCellStyle(borderStyle);
                                
                                Cell stepExpectedResultCell = row.createCell(5);
                                stepExpectedResultCell.setCellValue(stepEntity.getExpectedResult());
                                stepExpectedResultCell.setCellStyle(borderStyle);
                                
                                Cell stepCommentCell = row.createCell(6);
                                if (stepEntity.getComment() != null) {
                                    stepCommentCell.setCellValue(stepEntity.getComment());
                                    stepCommentCell.setCellStyle(borderStyle);
                                } else {
                                    stepCommentCell.setCellValue("-");
                                    stepCommentCell.setCellStyle(borderStyle);
                                } 
                            } else {
                                Row stepRow = sheet.createRow(j + 1 + k);
                                Cell stepNumberCell = stepRow.createCell(3);
                                stepNumberCell.setCellValue(stepEntity.getOrderNumber());
                                
                                Cell stepDescriptionCell = stepRow.createCell(4);
                                stepDescriptionCell.setCellValue(stepEntity.getDescription());
                                
                                Cell stepExpectedResultCell = stepRow.createCell(5);
                                stepExpectedResultCell.setCellValue(stepEntity.getExpectedResult());
                                
                                Cell stepCommentCell = stepRow.createCell(6);
                                if (stepEntity.getComment() != null) {
                                    stepCommentCell.setCellValue(stepEntity.getComment());
                                } else {
                                    stepCommentCell.setCellValue("-");
                                }               
                                rowCounter++;
                            }
                        }
                        caseIdCell.setCellStyle(borderStyle);
                        caseNameCell.setCellStyle(borderStyle);
                        caseDescriptionCell.setCellStyle(borderStyle);
                    }
                }
            }
            
            System.out.println(projectEntity.getName());
            FileOutputStream fos = new FileOutputStream("D:\\" + projectEntity.getName() + ".xlsx");
            workbook.write(fos);
            
        } catch (IOException e) {
            throw new ServiceException(e);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
        
    }

    @Override
    public void exportComponentIntoExcep(Long id) throws ServiceException {
        try {
            ComponentEntity componentEntity = this.componentRepository.getComponentEntityById(id);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

}
