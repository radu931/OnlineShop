import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrederDetailsComponent } from './oreder-details.component';

describe('a oreder-details component', () => {
	let component: OrederDetailsComponent;
	let fixture: ComponentFixture<OrederDetailsComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
		  declarations: [ OrederDetailsComponent ]
		})
		.compileComponents();
	  }));
	
	  beforeEach(() => {
		fixture = TestBed.createComponent(OrederDetailsComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	  });
	
	  it('should create', () => {
		expect(component).toBeTruthy();
	  });
	});