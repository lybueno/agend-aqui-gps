import { User } from "./user";


export type Schedule = {
    id: number;
    date: string;
    provider: User;
    client: User;
}

export type Schedules = {
    content: Schedule[];
}