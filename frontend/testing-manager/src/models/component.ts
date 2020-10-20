import { Case } from './case';
import { ComponentInstance } from './component-instance';

export interface Component {
    id: number;
    projectId: number;
    name: string;
    description: string;
    author: string;
    version: string;
    cases: Case[];
    componentInstances: ComponentInstance[];
}
