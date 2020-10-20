import { Component } from '@angular/core';

export interface Component {
    id: number;
    name: string;
    shortDescription: string;
    longDescription?: string;
    components: Component[];
}
