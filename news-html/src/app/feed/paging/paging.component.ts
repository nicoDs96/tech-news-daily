import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IndexService } from '../index.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-paging',
  templateUrl: './paging.component.html',
  styleUrls: ['./paging.component.css']
})
export class PagingComponent implements OnInit {
  pages: number;
  currentPage: number;
  prevPage: number | undefined;
  nextPage: number | undefined;

  constructor(private http: HttpClient, private idxService: IndexService) { 
    this.pages = 0; 
    this.currentPage = 0;
    this.prevPage = undefined;
  }

  ngOnInit(): void {
    this.http.get<number>(`${environment.endpoint}/feeds/pages`).subscribe(pagesNr => this.pages = pagesNr);
    this.idxService.idx.subscribe(value => {
      this.currentPage = value;
      value > 0 ? this.prevPage = value - 1 : this.prevPage = undefined;
      value != this.pages ? this.nextPage = value + 1 : this.nextPage = undefined;
    })
  }

  next(){
    if(this.currentPage < this.pages) this.idxService.next();
  }

  prev(){
    if(this.currentPage > 0) this.idxService.prev();
  }

}
