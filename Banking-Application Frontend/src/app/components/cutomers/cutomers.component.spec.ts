import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CutomersComponent } from './cutomers.component';

describe('CutomersComponent', () => {
  let component: CutomersComponent;
  let fixture: ComponentFixture<CutomersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CutomersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CutomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
