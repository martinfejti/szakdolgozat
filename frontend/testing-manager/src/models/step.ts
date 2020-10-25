import { StepInstance } from './step-instance';

export interface Step {
    id?: number;
    description?: string;
    expectedResult?: string;
    orderNumber?: number;
    comment?: string;
    stepInstances?: StepInstance[];
}
