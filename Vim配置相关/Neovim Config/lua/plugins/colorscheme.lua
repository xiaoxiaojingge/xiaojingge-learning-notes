return {
    -- {
    --     "neanias/everforest-nvim",
    --     priority = 1000,
    --     config = function()
    --         vim.cmd([[colorscheme everforest]])
    --     end
    -- }
    {
        "navarasu/onedark.nvim",
        priority = 1000,
        config = function()
            -- require("onedark").setup({
            --     style = 'deep',     -- Default theme style. Choose between 'dark', 'darker', 'cool', 'deep', 'warm', 'warmer' and 'light'
            --     transparent = true, -- Show/hide background
            --     code_style = {
            --         comments = 'italic',
            --         keywords = 'none',
            --         functions = 'none',
            --         strings = 'none',
            --         variables = 'none'
            --     }
            -- })
            vim.cmd([[colorscheme onedark]])
        end
    }
    -- {
    --     "Shatur/neovim-ayu",
    --     priority = 1000,
    --     config = function()
    --         vim.cmd([[colorscheme ayu-mirage]])
    --     end
    -- }
    -- {
    --     "shaunsingh/nord.nvim",
    --     priority = 1000,
    --     config = function()
    --         vim.cmd([[colorscheme nord]])
    --     end
    -- }
}
