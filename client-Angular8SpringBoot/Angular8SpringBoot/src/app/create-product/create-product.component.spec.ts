import { TestBed, inject } from '@angular/core/testing';

import { CreateProductComponent } from './create-product.component';

describe('a create-product component', () => {
	let component: CreateProductComponent;

	// register all needed dependencies
	beforeEach(() => {
		TestBed.configureTestingModule({
			providers: [
				CreateProductComponent
			]
		});
	});

	// instantiation through framework injection
	beforeEach(inject([CreateProductComponent], (CreateProductComponent) => {
		component = CreateProductComponent;
	}));

	it('should have an instance', () => {
		expect(component).toBeDefined();
	});
});