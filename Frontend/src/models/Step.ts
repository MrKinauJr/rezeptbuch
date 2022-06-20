export default  class Step {
    constructor(
        public title: string,
        public description: string,
        public stepNumber: number
    ) {
        this.title = title;
        this.stepNumber = stepNumber;
        this.description = description;
    }
}
