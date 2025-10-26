import { Routes } from '@angular/router';
import { ConferenceListComponent } from './pages/conference/conference-list.component/conference-list.component';
import { ConferenceAddComponent } from './pages/conference/conference-add.component/conference-add.component';
import { KeynoteListComponent } from './pages/keynotes/keynote-list.component/keynote-list.component';
import { ReviewListComponent } from './pages/reviews/review-list.component/review-list.component';
import { KeynoteDetaillsComponent } from './pages/keynotes/keynote-detaills.component/keynote-detaills.component';

export const routes: Routes = [
//   { path: '', redirectTo: '/conferences', pathMatch: 'full' },
  { path: 'conferences', component: ConferenceListComponent },
  { path: 'conferences/add', component: ConferenceAddComponent },
  { path: 'keynotes', component: KeynoteListComponent },
  {path: 'conferences/keynotes/:id', component: KeynoteDetaillsComponent},
  { path: 'reviews', component: ReviewListComponent }
];
