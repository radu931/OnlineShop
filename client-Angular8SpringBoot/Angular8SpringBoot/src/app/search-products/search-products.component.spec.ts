import { TestBed, inject } from '@angular/core/testing';

import { SearchProductsComponent } from './search-products.component';

describe('a search-products component', () => {
	let component: SearchProductsComponent;

	// register all needed dependencies
	beforeEach(() => {
		TestBed.configureTestingModule({
			providers: [
				SearchProductsComponent
			]
		});
	});

	// instantiation through framework injection
	beforeEach(inject([SearchProductsComponent], (SearchProductsComponent) => {
		component = SearchProductsComponent;
	}));

	it('should have an instance', () => {
		expect(component).toBeDefined();
	});
});