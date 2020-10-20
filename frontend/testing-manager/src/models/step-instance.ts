export interface StepInstance {
    id: number;
    stepId: number;
    caseInstanceId: number;
    testDate: Date;
    status: 'OK' | 'NOK' | 'ERR';
}
