import axios, {AxiosResponse} from "axios";
import Tag from "@/models/Tag";
import {TagDTO} from "@/DTOs/TagDTO";

export default class TagService {
    private static BASE_URL = window.location.origin + "/api/tags";

    public getTags(): Promise<Tag[]> {
        return new Promise<Tag[]>((resolve, reject) => {
            axios.get(TagService.BASE_URL, {withCredentials: true}).then((response: AxiosResponse<TagDTO[]>) => {
                const tags: Tag[] = [];
                response.data.forEach((tagDTO: TagDTO) => {
                    tags.push(new Tag(tagDTO.id as string, tagDTO.name));
                });
                resolve(tags)
            }).catch((error) => {
                reject(error);
            });
        });


    }
}