import { Step } from './step';

export interface Case {
    id?: number;
    name?: string;
    description?: string;
    componentId?: number;
    steps?: Step[];
}
