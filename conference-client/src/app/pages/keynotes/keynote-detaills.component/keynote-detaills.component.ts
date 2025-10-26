import { Component, OnInit, signal } from '@angular/core';
import { Keynote } from '../../../shared/models/keynote.model';
import { KeynoteService } from '../../../core/services/keynote.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-keynote-detaills.component',
  imports: [],
  templateUrl: './keynote-detaills.component.html',
  styleUrl: './keynote-detaills.component.css',
})
export class KeynoteDetaillsComponent implements OnInit{


    ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.getKeynote(id);
    }

    constructor(private keynoteService: KeynoteService,    private route: ActivatedRoute){
    
    }

    getKeynote(id: number) {
      this.keynoteService.getKeynote(id).subscribe({
        next: (data) => {
          this.keynote = data;
          this.loading.set(false);
          console.log(data);
        },
        error: err => {
          console.error("error fetching keynote detailles" , err)
          this.loading.set(false)
        }
      }
      )
    }

    keynote?: Keynote;
    loading = signal(true);

    

}
