import { Component } from '@angular/core';

export interface Project {
    id: number;
    name: string;
    shortDescription: string;
    longDescription?: string;
    components: Component[];
}
