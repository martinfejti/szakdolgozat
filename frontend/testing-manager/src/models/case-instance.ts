import { StepInstance } from './step-instance';

export interface CaseInstance {
    id?: number;
    caseId?: number;
    componentInstanceId?: number;
    createDate?: Date;
    closeDate?: Date;
    stepInstances?: StepInstance[];
}
