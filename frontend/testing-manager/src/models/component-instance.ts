import { CaseInstance } from './case-instance';

export interface ComponentInstance {
    id: number;
    componentId: number;
    createDate: Date;
    closeDate: Date;
    caseInstances: CaseInstance[];
}
