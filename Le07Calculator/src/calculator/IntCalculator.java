package calculator;

/**
 * Eenvoudige integer calculator die wordt gereset als het eindresultaat wordt
 * opgevraagd.
 * 
 * @author Open Universiteit Nederland
 * 
 */
public class IntCalculator {

  private int cumulatief = 0;
  private OperatorEnum huidigeoperator = OperatorEnum.SOM;

  /**
   * Berekent het nieuw cumulatiefresultaat door de huidige OperatorEnum toe te
   * passen op het cumulatief resultaat en de gegeven operand. Wijzigt daarna
   * de huidigeoperator in de gegeven OperatorEnum en geeft het nieuw
   * cumulatiefresultaat terug.
   * @param operand2  de gegeven operand
   * @param op  de gegeven OperatorEnum
   * @return cumulatiefresultaat
   */
  public int bereken(int operand2, OperatorEnum op) {
    berekenCumulatief(operand2);
    huidigeoperator = op;
    return cumulatief;
  }

  /**
   * Wijzigt het cumelatief resultaat door huidige OperatorEnum toe te
   * passen op het cumulatief resultaat en de gegeven operand.
   * @param operand2 de operand
   */
  private void berekenCumulatief(int operand2) {
    switch (huidigeoperator) {
      case SOM:
        cumulatief = cumulatief + operand2;
        break;
      case VERSCHIL:
        cumulatief = cumulatief - operand2;
        break;
      case PRODUCT:
        cumulatief = cumulatief * operand2;
        break;
      case QUOTIENT:
        cumulatief = cumulatief / operand2;
        break;
    }
  }

  /**
   * Reset de calculator
   */
  private void reset() {
    huidigeoperator = OperatorEnum.SOM;
    cumulatief = 0;
  }

  /**
   * Berekent het nieuw cumulatiefresultaat door de huidige OperatorEnum toe te
   * passen op het cumulatief resultaat en de gegeven operand. 
   * @param operand2 de gegeven operand
   * @return het cumlatief resultaat   
   */
  public int getEindResultaat(int operand2) {
    berekenCumulatief(operand2);
    int result = cumulatief;
    reset();
    return result;
  }

}
