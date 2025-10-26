import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConferenceAddComponent } from './conference-add.component';

describe('ConferenceAddComponent', () => {
  let component: ConferenceAddComponent;
  let fixture: ComponentFixture<ConferenceAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConferenceAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConferenceAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
