import { Keynote } from "./keynote.model";

export interface Conference {
  id?: number;
  title: string;
  date: string;
  duration?: number;
  score?: number;
  inscriptions?: number;
  keynoteId?: number;
  keynote?: Keynote;
}