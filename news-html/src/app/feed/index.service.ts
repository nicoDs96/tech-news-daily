import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IndexService {
  idx: BehaviorSubject<number>;
  
  constructor() { 
    this.idx = new BehaviorSubject(0);
  }

  next(){
    this.idx.next(this.idx.getValue() + 1)
  }
  prev(){
    this.idx.next(this.idx.getValue() - 1)
  }
  goto(n: number){
    this.idx.next(n)
  }
}
