import { cookies, headers } from "next/headers";

const Main_Section = async () => {
  // Where we will make a request 
  const response = ({
    cookies,
    headers,
  });

  // const { data: userData, error: userError } = store our user data

  // const res =  Get the tweets we need

  return (
    <main className="flex w-full h-full min-h-screen flex-col border-l-[0.5px] border-r-[0.5px] border-gray-600">
      <h1 className="text-xl font-bold p-6 backdrop-blur bg-black/10 sticky top-0">
        Home
      </h1>
      <div className="border-t-[0.5px] px-4 border-b-[0.5px] flex items-stretch py-6 space-x-2 border-gray-600 relative">
        <div className="w-11 h-11 bg-slate-400 rounded-full flex-none"></div>
        {/* Compose a tweet using a map */}
      </div>
      <div className="w-full">
        
      </div>
    </main>
  );
};

export default Main_Section;