export default  class Step {
    constructor(
        public description: string,
        public duration: number
    ) {
        this.description = description;
        this.duration = duration;
    }
}
