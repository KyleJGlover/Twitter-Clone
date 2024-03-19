import Left_Section from "@/components/Left_Section";
import Main_Section from "@/components/Main_Section";
import Right_Section from "@/components/Right_Section";


const Home = async () => {
  return (
    <div className="w-full h-full flex justify-center items-center relative bg-black">
      <div className="max-w-[70vw] w-full h-full flex relative">
        <Left_Section/>
        <Main_Section/>
        <Right_Section/>
      </div>
      <div>
        Footer
      </div>
    </div>
    
  )
};

export default Home;