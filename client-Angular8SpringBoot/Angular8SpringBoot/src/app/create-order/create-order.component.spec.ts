import { TestBed, inject } from '@angular/core/testing';

import { CreateOrderComponent } from './create-order.component';

describe('a create-order component', () => {
	let component: CreateOrderComponent;

	// register all needed dependencies
	beforeEach(() => {
		TestBed.configureTestingModule({
			providers: [
				CreateOrderComponent
			]
		});
	});

	// instantiation through framework injection
	beforeEach(inject([CreateOrderComponent], (CreateOrderComponent) => {
		component = CreateOrderComponent;
	}));

	it('should have an instance', () => {
		expect(component).toBeDefined();
	});
});