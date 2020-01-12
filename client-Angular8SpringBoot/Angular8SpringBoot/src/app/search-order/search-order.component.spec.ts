import { TestBed, inject } from '@angular/core/testing';

import { SearchOrderComponent } from './search-order.component';

describe('a search-order component', () => {
	let component: SearchOrderComponent;

	// register all needed dependencies
	beforeEach(() => {
		TestBed.configureTestingModule({
			providers: [
				SearchOrderComponent
			]
		});
	});

	// instantiation through framework injection
	beforeEach(inject([SearchOrderComponent], (SearchOrderComponent) => {
		component = SearchOrderComponent;
	}));

	it('should have an instance', () => {
		expect(component).toBeDefined();
	});
});