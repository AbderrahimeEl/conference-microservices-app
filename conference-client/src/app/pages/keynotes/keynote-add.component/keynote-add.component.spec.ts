import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KeynoteAddComponent } from './keynote-add.component';

describe('KeynoteAddComponent', () => {
  let component: KeynoteAddComponent;
  let fixture: ComponentFixture<KeynoteAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KeynoteAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KeynoteAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
